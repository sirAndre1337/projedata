import { useEffect, useState } from 'react';
import { Controller, set, useForm } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import Select from 'react-select';
import { toast } from 'react-toastify';
import {  AmountFeedstocks, Feedstock, FeedstocksResponse, Product } from '../../../../core/types/Entities';
import { makeRequest } from '../../../../core/utils/request';
import Card from '../../Card';
import './styles.scss';

const FormAmntFeed = () => {


    type FormState = {
        feedstocks: Feedstock;
        amount: number;
    }


    type ParamsType = {
        productId: string;
    }

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<FormState>();
    const history = useHistory();
    const { productId } = useParams<ParamsType>();
    const [product, setProduct] = useState<Product>();
    const [feedstockResponse, setFeedstockResponse] = useState<FeedstocksResponse>();
    const [feedstocks, setFeedstocks] = useState<Feedstock[]>([])
    const [amountFeedstockResponse, setAmountFeedStockResponse] = useState<AmountFeedstocks[]>([]);
    const [feedstockID, setFeedStockID] = useState();

    useEffect(() => {
        makeRequest({ url: `/afs/${productId}` })
            .then(response => {
                //setValue('amount', response.data[0].amount);
                setValue('feedstocks', response.data[0].feedstock_id);
                setAmountFeedStockResponse(response.data);
                //console.log(amountFeedstockResponse);
                
            })
    }, [productId,setValue])

    useEffect(() => {
        makeRequest({ url: `/products/${productId}` })
            .then(response => {
                setProduct(response.data)                
            })
    }, [productId]);

    useEffect(() => {
        makeRequest({ url: '/feedstocks' })
            .then(response => setFeedstocks(response.data.content))
    }, [])

    

    const onSubmit = (formData: FormState) => {

        const payload = { "amount": formData.amount, "product_id": productId, "feedstock_id": formData.feedstocks.id }

        makeRequest({ url: '/afs', method: 'POST', data: payload })
            .then(() => {
                toast.info('Product update');
                history.push('/admin/products');
            })
            .catch(() => {
                toast.error('Erro ao salvar produto!');
            })
    };
    return (
        <div className="admin-product-container">
                <h1 className='base-form-title'>
                        Produto - {product?.name}
                    </h1>
            {amountFeedstockResponse?.map(afs => (
                <form onSubmit={handleSubmit(onSubmit)}>
                <div className='admin-base-form card-base'>
                    {setValue('amount', afs.amount, {shouldDirty : true})} 
                    <div className='mb-4'>
                        <Controller
                            name="feedstocks"
                            control={control}
                            render={({ field }) =>
                                <Select
                                    {...field}
                                    getOptionLabel={(option: Feedstock) => option.name}
                                    getOptionValue={(option: Feedstock) => String(option.id)}
                                    options={feedstocks}
                                    placeholder="Feedstock"
                                    classNamePrefix="feedstock-select"
                                />}
                        />
                        {errors.feedstocks &&
                            <div className='invalid-feedback d-block'>
                                Campo obrigatório
                            </div>}
                    </div>
                    <div className='mb-4'>
                        <input
                            value={afs.amount}
                            type="string"
                            className={`form-control input-base ${errors.amount ? 'is-invalid' : ''}`}
                            placeholder='Amount'
                            {...register('amount', { required: 'Campo preço obrigatório' })}
                        />
                        {errors.amount &&
                            <div className='invalid-feedback d-block'>
                                {errors.amount.message}
                            </div>}
                    </div>
                    <div className='base-form-actions'>
                        <button
                            className='btn btn-danger w-25'
                        //onClick={handleCancel}
                        >
                            CANCEL
                        </button>
                        <button className='btn btn-primary w-25'>
                            SAVE
                        </button>
                    </div>
                </div>
            </form>
            )
        )}
            
        </div>
    )
}

export default FormAmntFeed;


import { useEffect, useState } from 'react';
import { Controller, useForm, useFormState } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import { AmountFeedstocks, Feedstock } from '../../../../core/types/Entities';
import { makeRequest } from '../../../../core/utils/request';
import BaseForm from '../../BaseForm';
import Select from 'react-select';
import './styles.scss';

const Form = () => {

    type FormState = {
        name: string;
        price: string;
        feedstocks: Feedstock;
        amount: number;

    }

    type ParamsType = {
        productId: string;
    }

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<FormState>();
    const history = useHistory();
    const { productId } = useParams<ParamsType>();
    const isEditing = productId !== 'create';
    const [feedstocks, setFeedstocks] = useState<Feedstock[]>([]);
    const [select, setSelect] = useState();
    const [a, setA] = useState<Feedstock>();
    const [amount, setAmount] = useState('');
    const payload = [{}]

    const handleSelectFeedstock = (e: any) => {
        setSelect(e);
        setA(e);
    }

    const handlePayload = () => {


    }

    useEffect(() => {
        if (isEditing) {
            makeRequest({ url: `/products/${productId}` })
                .then(response => {
                    setValue('name', response.data.name);
                    setValue('price', response.data.price);
                })
        }
    }, [productId, isEditing, setValue]);


    useEffect(() => {
        makeRequest({ url: '/feedstocks' })
            .then(reponse => { setFeedstocks(reponse.data.content) });
    }, [])

    const onSubmit = (formData: FormState) => {

        makeRequest({
            url: isEditing ? `/products/${productId}` : '/products',
            method: isEditing ? 'PUT' : 'POST',
            data: formData
        })
            .then(() => {
                toast.info(isEditing ? 'Produto atualizado com sucesso!' : 'Produto salvo com sucesso!');
                history.push('/admin/products');
            })
            .catch(() => {
                toast.error('Erro ao salvar produto!');
            })
    };


    return (
        <div className="admin-product-container">
            <form onSubmit={handleSubmit(onSubmit)}>
                <BaseForm title={isEditing ? 'Editar produto' : 'Cadastrar um produto'} isProduct={true}>
                    <div className='row'>
                        <div className="">
                            <div className='mb-4'>
                                <input
                                    type="text"
                                    className={`form-control input-base ${errors.name ? 'is-invalid' : ''}`}
                                    placeholder='Nome do produto'
                                    {...register('name', {
                                        required: 'Campo nome obrigatório',
                                        minLength: { value: 2, message: 'O Campo deve ter no mínimo 2 caracteres' },
                                        maxLength: { value: 50, message: 'O Campo deve ter no máximo 50 caracteres' }
                                    })}
                                />
                                {errors.name &&
                                    <div className='invalid-feedback d-block'>
                                        {errors.name.message}
                                    </div>}
                            </div>
                            <div className='mb-4'>
                                <Controller
                                    rules={{ required: true }}
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
                                            onChange={handleSelectFeedstock}
                                            isOptionSelected={select}
                                        />}
                                />
                                {errors.feedstocks &&
                                    <div className='invalid-feedback d-block'>
                                        Campo obrigatório
                                    </div>}
                            </div>
                            {a &&
                                <div className='mb-4'>
                                    <input
                                        type="number"
                                        value={amount}
                                        className='form-control input-base'
                                        placeholder='Amount'
                                        onChange={(e) => { setAmount(e.target.value) }}
                                    />

                                    <button className='btn btn-success mt-2' onClick={e => { e.preventDefault(); handlePayload() }}>
                                        Save feedstock
                                    </button>
                                </div>

                            }

                            <div className='mb-4'>
                                <input
                                    type="number"
                                    className={`form-control input-base ${errors.price ? 'is-invalid' : ''}`}
                                    placeholder='Preço'
                                    {...register('price', { required: 'Campo preço obrigatório' })}
                                />
                                {errors.price &&
                                    <div className='invalid-feedback d-block'>
                                        {errors.price.message}
                                    </div>}
                            </div>
                        </div>
                    </div>
                </BaseForm>
            </form>
        </div>
    )
}

export default Form;
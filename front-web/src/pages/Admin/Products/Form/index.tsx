import { useEffect, useState } from 'react';
import { Controller, useForm, useFormState } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import { AmountFeedstocks, Feedstock } from '../../../../core/types/Entities';
import { makeRequest } from '../../../../core/utils/request';
import BaseForm from '../../BaseForm';
import Select, { ActionMeta, GroupBase, Options, Props } from 'react-select';
import './styles.scss';

const Form = () => {

    type FormState = {
        name: string;
        price: string;
    }

    type ParamsType = {
        productId: string;
    }

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<FormState>();
    const history = useHistory();
    const { productId } = useParams<ParamsType>();
    const isEditing = productId !== 'create';

    useEffect(() => {
        if (isEditing) {
            makeRequest({ url: `/products/${productId}` })
                .then(response => {
                    setValue('name', response.data.name);
                    setValue('price', response.data.price);
                    console.log(response.data.name);
                    
                })
        }
    }, [productId, isEditing, setValue]);

    const onSubmit = (formData: FormState) => {

        //let fs = formData.feedstocks.id;
        let nam = formData.name;
        let pe = formData.price

        const payload = { name: nam, price: pe, amountFeedstocks: [{ feedstock: { id: 2 } }] }

        console.log(formData);
        console.log(payload);

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
    
    const payload = [{}];

    const handlePayload = () => {
        //const objsave = {"amount" : amount , "feedstock" : {"id":selectOption?.id}}; 
        
        // if (aux === 0) {
        //     amountFeedstocks.push(objsave);
        //     setAux(aux + 1);
        //     console.log(amountFeedstocks);            
        //     console.log("aux é : " + aux);
        // } else {
        //     let newobj = [...amountFeedstocks , objsave]
        //     console.log(newobj);
        //     console.log("entrou no else");
            
        // }

        //const payload = {amountFeedstocks: [{"amount" : amount , "feedstock" : {"id":selectOption?.id}}]}

        //payload.amountFeedstocks.push(...payload.amountFeedstocks , {"amount" : amount})

        //console.log(payload);
        
    }

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
                                <input
                                    type="string"
                                    className={`form-control input-base ${errors.price ? 'is-invalid' : ''}`}
                                    placeholder='Preço'
                                    {...register('price', { required: 'Campo preço obrigatório' })}
                                />
                                {errors.price &&
                                    <div className='invalid-feedback d-block'>
                                        {errors.price.message}
                                    </div>}
                            </div>
                            {/* <div className='mb-4'>
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
                                            onChange={handleChange}
                                        />}
                                />
                                {errors.feedstocks &&
                                    <div className='invalid-feedback d-block'>
                                        Campo obrigatório
                                    </div>}
                            </div> */}
                            {/* {selectOption &&
                                <div className='mb-4'>
                                    <input
                                        type="number"
                                        value={amount}
                                        className='form-control input-base'
                                        placeholder='Amount'
                                        onChange={(e) => { setAmount(e.target.value)}}
                                    />

                                    <button className='btn btn-success mt-2' onClick={e => { e.preventDefault(); handlePayload() }}>
                                        Save feedstock
                                    </button>
                                </div>} */}
                        </div>
                    </div>
                </BaseForm>
            </form>
        </div>
    )
}

export default Form;
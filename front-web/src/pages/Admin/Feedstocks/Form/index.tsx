import { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import { makeRequest } from '../../../../core/utils/request';
import BaseForm from '../../BaseForm';
import './styles.scss';

const Form = () => {

    type FormState = {
        name: string;
        amount: number;
    }

    type ParamsType = {
        feedstockId: string;
    }

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<FormState>();
    const history = useHistory();
    const { feedstockId } = useParams<ParamsType>();
    const isEditing = feedstockId !== 'create';

    useEffect(() => {
        if (isEditing) {
            makeRequest({ url: `/feedstocks/${feedstockId}` })
                .then(response => {
                    setValue('name', response.data.name);
                    setValue('amount', response.data.amount);
                })
        }
    }, [feedstockId, isEditing, setValue]);

    const onSubmit = (formData: FormState) => {

        makeRequest({
            url: isEditing ? `/feedstocks/${feedstockId}` : '/feedstocks',
            method: isEditing ? 'PUT' : 'POST',
            data: formData
        })
            .then(() => {
                toast.info(isEditing ? 'Feedstock successfully updated!' : 'Feedstock saved successfully!');
                history.push('/admin/feedstocks');
            })
            .catch(() => {
                toast.error('Error saving feedstock!');
            })
    };


    return (
        <div className="admin-product-container">
            <form onSubmit={handleSubmit(onSubmit)}>
                <BaseForm title={isEditing ? 'Edit feedstock' : 'Save new feedstock'} isProduct={false}>
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
                                    type="number"
                                    className={`form-control input-base ${errors.amount ? 'is-invalid' : ''}`}
                                    placeholder='Amount'
                                    {...register('amount', { required: 'Mandatory amount field' })}
                                />
                                {errors.amount &&
                                    <div className='invalid-feedback d-block'>
                                        {errors.amount.message}
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
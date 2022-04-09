import { useHistory } from 'react-router-dom';
import './styles.scss';

type Props = {
    title: string
    children: React.ReactNode;
    isProduct: boolean
}

const BaseForm = ({ title, children, isProduct }: Props) => {
    const history = useHistory();
    const handleCancel = () => {
        if (isProduct === true){
            history.push('../products');
        } else {
            history.push('../feedstocks')
        }
    }

    return (
        <div className='admin-base-form card-base'>
            <h1 className='base-form-title'>
                {title}
            </h1>
            {children}
            <div className='base-form-actions'>
                <button
                    className='btn btn-danger w-25'
                    onClick={handleCancel}
                >
                    CANCEL
                </button>
                <button className='btn btn-primary w-25'>
                    SAVE
                </button>
            </div>
        </div>
    )
}

export default BaseForm;
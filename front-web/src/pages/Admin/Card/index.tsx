import { Link } from 'react-router-dom';
import { Product } from '../../../core/types/Entities';
import './styles.scss';

type Props = {
    product: Product
    onRemove: (productId: number) => void;
}

const Card = ({product, onRemove} : Props) => {
    return (
        <div className="card-base product-card-admin">
            <div className='card-content'>
                    <h3 className='product-card-name-admin'>
                        {product.name}
                    </h3>
                        {product.price} R$
                </div>
                <div className='buttons-container'>
                    <Link
                        to={`/admin/products/${product.id}`}
                        type="button"
                        className="btn btn-outline-secondary btn-product mb-3"
                    >
                        EDITAR
                    </Link>
                    <button
                        type="button"
                        className="btn btn-outline-danger btn-product"
                        onClick={() => onRemove(product.id)}
                    >
                        EXCLUIR
                    </button>
                </div>
        </div>
    )
}

export default Card;
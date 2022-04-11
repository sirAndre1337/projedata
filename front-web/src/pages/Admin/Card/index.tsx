import { Link } from 'react-router-dom';
import { Feedstock, Product } from '../../../core/types/Entities';
import './styles.scss';

type Props = {
    product?: Product
    onRemove: (productId: number) => void;
    isProduct: boolean,
    feedstock?: Feedstock
}

const Card = ({ product, onRemove, isProduct, feedstock }: Props) => {
    return (
        <>
            {isProduct ? <div className="card-base product-card-admin">
                <div className='card-content'>
                    <h3 className='product-card-name-admin'>
                        {product?.name}
                    </h3>
                    {product?.price} R$
                </div>
                <div className='buttons-container'>
                    <Link
                        to={`/admin/products/${product?.id}`}
                        type="button"
                        className="btn btn-outline-secondary btn-product mb-3"
                    >
                        UPDATE
                    </Link>
                    <Link
                        to={`/admin/products/amountfeedstocks/${product?.id}`}
                        type="button"
                        className="btn btn-outline-secondary btn-product mb-3"
                    >
                        RAW MATERIAL
                    </Link>
                    <button
                        type="button"
                        className="btn btn-outline-danger btn-product"
                        onClick={() => onRemove(product !== undefined ? product?.id : 0)}
                    >
                        DELETE
                    </button>
                </div>
            </div> : 
            <div className="card-base product-card-admin">
                <div className='card-content'>
                    <h3 className='product-card-name-admin'>
                        {feedstock?.name}
                    </h3>
                </div>
                <div className='buttons-container'>
                    <Link
                        to={`/admin/feedstocks/${feedstock?.id}`}
                        type="button"
                        className="btn btn-outline-secondary btn-product mb-3"
                    >
                        UPDATE
                    </Link>
                    <button
                        type="button"
                        className="btn btn-outline-danger btn-product"
                        onClick={() => onRemove(feedstock !== undefined ? feedstock?.id : 0)}
                    >
                        DELETE
                    </button>
                </div>
            </div>}
        </>
    )
}

export default Card;
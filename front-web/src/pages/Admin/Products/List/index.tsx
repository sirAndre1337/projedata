import { useCallback, useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import { toast } from 'react-toastify';
import Filters from '../../../../core/components/Filters';
import Pagination from '../../../../core/components/Pagination';
import { ProductsResponse } from '../../../../core/types/Entities';
import { makeRequest } from '../../../../core/utils/request';
import Card from '../../Card';
import './styles.scss';

const List = () => {

    const history = useHistory();
    const [productResponse, setProductResponse] = useState<ProductsResponse>();
    const [activePage, setActivePage] = useState(0);
    const [name, SetName] = useState('');


    const getProducts = useCallback(() => {
        const params = {
            page: activePage,
            linesPerPage: 4,
            name: name,
            direction: 'DESC',
            orderBy: 'id'
        }

        makeRequest({ url: '/products', params: params })
            .then(response => setProductResponse(response.data));

    }, [activePage, name])

    useEffect(() => {
        getProducts();
    }, [getProducts])

    const handleCreate = () => {
        history.push('/admin/products/create');
    }

    const handleChangeName = (name: string) => {
        setActivePage(0);
        SetName(name);
    }

    const clearFilters = () => {
        setActivePage(0);
        SetName('');
    }

    console.log(name);
    

    const onRemove = (productId: number) => {
        const confirm = window.confirm('Deseja realmente excluir este produto?');

        if (confirm) {
            makeRequest({ url: `/products/${productId}`, method: 'DELETE' })
                .then(() => {
                    toast.info('Produto removido com sucesso!');
                    getProducts();
                }).catch(() => {
                    toast.error('Error ao remover o produto');
                })
        }
    }

    return (
        <div className="admin-product-container">
            <div className='admin-products-list'>
                <div className='admin-product-btn-filter mb-5'>
                    <button className='admin-product-btn btn btn-primary' onClick={handleCreate}>
                        New Product
                    </button>
                    <Filters
                        name={name}
                        handleChangeName={handleChangeName}
                        clearFilters={clearFilters}
                    />
                </div>
                <div className='admin-list-container'>
                    {productResponse?.content.map(product => (
                        <Card product={product} key={product.id} onRemove={onRemove}/>
                    ))}
                </div>
                {productResponse && <Pagination
                totalPages={productResponse.totalPages}
                onChange={page => setActivePage(page)}
                 />}
            </div>
        </div>
    )
}

export default List;
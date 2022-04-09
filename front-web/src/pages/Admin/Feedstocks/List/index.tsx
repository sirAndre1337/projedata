import { useCallback, useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import { toast } from 'react-toastify';
import Filters from '../../../../core/components/Filters';
import Pagination from '../../../../core/components/Pagination';
import { FeedstocksResponse, ProductsResponse } from '../../../../core/types/Entities';
import { makeRequest } from '../../../../core/utils/request';
import Card from '../../Card';
import './styles.scss';

const List = () => {

    const history = useHistory();
    const [feedstockResponse, setFeedstockResponse] = useState<FeedstocksResponse>();
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

        makeRequest({ url: '/feedstocks', params: params })
            .then(response => setFeedstockResponse(response.data));

    }, [activePage, name])

    useEffect(() => {
        getProducts();
    }, [getProducts])

    const handleCreate = () => {
        history.push('/admin/feedstocks/create');
    }

    const handleChangeName = (name: string) => {
        setActivePage(0);
        SetName(name);
    }

    const clearFilters = () => {
        setActivePage(0);
        SetName('');
    }    

    const onRemove = (feedstockId: number) => {
        const confirm = window.confirm('Do you want to delete this feedstock ?');

        if (confirm) {
            makeRequest({ url: `/feedstocks/${feedstockId}`, method: 'DELETE' })
                .then(() => {
                    toast.info('Feedstock removed successfully!');
                    getProducts();
                }).catch(() => {
                    toast.error('Error removing feedstock');
                })
        }
    }

    return (
        <div className="admin-product-container">
            <div className='admin-products-list'>
                <div className='admin-product-btn-filter mb-5'>
                    <button className='admin-product-btn btn btn-primary' onClick={handleCreate}>
                        New Feedstock
                    </button>
                    <Filters
                        placeholder='Search Feedstock'
                        name={name}
                        handleChangeName={handleChangeName}
                        clearFilters={clearFilters}
                    />
                </div>
                <div className='admin-list-container'>
                    {feedstockResponse?.content.map(feedstock => (
                        <Card feedstock={feedstock} key={feedstock.id} onRemove={onRemove} isProduct={false}/>
                    ))}
                </div>
                {feedstockResponse && <Pagination
                totalPages={feedstockResponse.totalPages}
                onChange={page => setActivePage(page)}
                 />}
            </div>
        </div>
    )
}

export default List;
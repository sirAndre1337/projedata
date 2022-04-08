import './styles.scss'
import { ReactComponent as ArrowIcon } from '../../assets/images/arrow.svg';
import ReactPaginate from 'react-paginate';

type Props = {
    totalPages: number
    onChange: (item: number) => void;
}

const Pagination = ({ totalPages, onChange }: Props) => {
    

    const renderIcon = (icon: 'previous' | 'next') => (
        <ArrowIcon
                className={`pagination-${icon}`}
            />
    );

    return (
        <div className="pagination-container">
            <ReactPaginate 
            pageCount={totalPages}
            pageRangeDisplayed={5}
            marginPagesDisplayed={1}
            onPageChange={selectedItem => onChange(selectedItem.selected)}
            previousLabel={renderIcon('previous')}
            nextLabel={renderIcon('next')}
            containerClassName="pagination"
            pageLinkClassName='pagination-item'
            breakClassName='pagination-item'
            activeLinkClassName='active'
            previousClassName='page-active'
            nextClassName='page-active'
            disabledClassName='page-inactive'
            onClick={() => window.scrollTo(0, 0)}
            />
        </div>

    );
};

export default Pagination;
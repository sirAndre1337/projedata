import './styles.scss';

type Props = {
    name?: string;
    handleChangeName: (name: string) => void;
    clearFilters: () => void;
    placeholder?: string
}

const Filters = ({ name,handleChangeName,clearFilters,placeholder} : Props) => {
    return (
        <div className="card-base product-filters-container">
            <div className='input-search'>
                <input
                    value={name}
                    type="text"
                    className='form-control'
                    placeholder={placeholder}
                    onChange={event => handleChangeName(event.target.value)}
                />
            </div>
            <button
                className='btn btn-edit border-radius-10'
                onClick={clearFilters}
            >
                CLEAN FILTERS
            </button>
        </div>
    )
}

export default Filters
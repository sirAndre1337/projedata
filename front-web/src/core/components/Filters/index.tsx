import './styles.scss';

type Props = {
    name?: string;
    handleChangeName: (name: string) => void;
    clearFilters: () => void;
}

const Filters = ({ name,handleChangeName,clearFilters} : Props) => {
    return (
        <div className="card-base product-filters-container">
            <div className='input-search'>
                <input
                    value={name}
                    type="text"
                    className='form-control'
                    placeholder='Pesquisar Produto'
                    onChange={event => handleChangeName(event.target.value)}
                />
            </div>
            <button
                className='btn btn-edit border-radius-10'
                onClick={clearFilters}
            >
                LIMPAR FILTRO
            </button>
        </div>
    )
}

export default Filters
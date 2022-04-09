import './styles.scss';
import { ReactComponent as Background } from '../../core/assets/images/background.svg';import { Link } from 'react-router-dom';

const Home = () => (
    <>
        <div className="home-container ">
            <div className='home-content card-base'>
                <h1 className='text-title'>
                    System to manage an industry.
                </h1>
                <p className='text-subtitle'> 
                    Manage your products and raw materials.
                </p>
                <Background className='home-img'/>
                <div className='d-flex justify-content-center'>
                <Link to="/admin/products">
                    <button className='btn btn-primary home-btn'>Product</button>
                </Link>
                <Link to="/admin/feedstocks">
                    <button className='btn btn-primary home-btn'>Feedstock</button>
                </Link>
                <Link to="/admin">
                    <button className='btn btn-primary home-btn'>Manufacture</button>
                </Link>
                </div>
            </div>
        </div>
    </>
)

export default Home;
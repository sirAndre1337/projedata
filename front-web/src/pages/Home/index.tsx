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
                <Link to="/admin">
                    <button className='btn btn-primary home-btn'>Acess system</button>
                </Link>
            </div>
        </div>
    </>
)

export default Home;
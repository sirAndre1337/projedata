import './styles.scss';
import { ReactComponent as Logo } from '../../assets/images/projedata.svg';
import { Link } from 'react-router-dom';

const Navbar = () => (
    <nav className="main-nav">
        <Link to="/home">
            <Logo className='main-nav-logo'/>
        </Link>
    </nav>
)

export default Navbar;
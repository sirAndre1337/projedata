import './styles.scss';
import { ReactComponent as Logo } from '../../assets/images/projedata.svg';

const Navbar = () => (
    <nav className="main-nav">
        <Logo className='main-nav-logo'/>
    </nav>
)

export default Navbar;
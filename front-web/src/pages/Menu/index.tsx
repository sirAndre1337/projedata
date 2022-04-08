import { NavLink } from 'react-router-dom';
import './styles.scss';

const Menu = () => (
    <nav className='menu-nav-container'>
        <ul>
        <li>
                <NavLink to="/" className="menu-nav-item">
                    Home
                </NavLink>
            </li>
            <li>
                <NavLink to="/admin" className="menu-nav-item">
                     Product registration
                </NavLink>
            </li>
            <li>
                <NavLink to="/products" className="menu-nav-item">
                    Feedstock registration 
                </NavLink>
            </li>
            <li>
                <NavLink to="/products" className="menu-nav-item">
                    Manufacture
                </NavLink>
            </li>
        </ul>
    </nav>
)

export default Menu;

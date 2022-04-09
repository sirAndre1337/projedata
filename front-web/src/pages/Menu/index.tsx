import { NavLink } from 'react-router-dom';
import './styles.scss';

const Menu = () => (
    <nav className='menu-nav-container'>
        <ul>
            <li>
                <NavLink to="/admin/products" className="menu-nav-item">
                     Product
                </NavLink>
            </li>
            <li>
                <NavLink to="/admin/feedstocks" className="menu-nav-item">
                    Feedstock 
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

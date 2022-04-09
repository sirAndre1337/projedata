import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Navbar from './core/components/Navbar';
import Home from './pages/Home';
import Menu from './pages/Menu';
import Admin from './pages/Admin';
import Products from './pages/Admin/Products';
import Feedstocks from './pages/Admin/Feedstocks';

const Routes = () => (
    <BrowserRouter>
        <Navbar />
                <Switch>
                <Redirect from='/home' to="/" exact />
                    <Route path="/" exact>
                        <Home />
                    </Route>
                    <Route path="/admin/products">
                        <Products />
                    </Route>
                    <Route path="/admin/feedstocks">
                        <Feedstocks />
                    </Route>
                </Switch>
    </BrowserRouter>
)

export default Routes;
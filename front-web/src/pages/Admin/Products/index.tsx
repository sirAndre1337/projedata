import { Route, Switch } from 'react-router-dom';
import Menu from '../../Menu';
import Form from './Form';
import FormAmntFeed from './FormAmntFeed';
import List from './List';
import './styles.scss';

const Products = () => {

    return (
        <div className="d-flex">
            <Menu />
                <Switch>
                    <Route path="/admin/products" exact>
                        <List />
                    </Route>
                    <Route path="/admin/products/:productId" exact>
                        <Form />
                    </Route>
                    <Route path="/admin/products/amountfeedstocks/:productId">
                        <FormAmntFeed />
                    </Route>
                </Switch>
        </div>
    )
}

export default Products;
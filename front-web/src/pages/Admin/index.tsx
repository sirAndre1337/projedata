import { Route, Switch } from "react-router-dom";
import Menu from "../Menu";
import Products from "./Products";
import './styles.scss';

const Admin = () => (
    
        <div>
            <Switch>
                    <Route path="admin/products">
                        <Products />
                    </Route>
                    <Route path="admin/feedstocks">
                        Feedstocks
                    </Route>
                    <Route path="admin/manufactures">
                        Manufacture
                    </Route>
            </Switch>
        </div>
)

export default Admin;
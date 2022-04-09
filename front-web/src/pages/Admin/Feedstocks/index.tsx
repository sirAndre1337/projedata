import { Route, Switch } from 'react-router-dom';
import Menu from '../../Menu';
import Form from './Form';
import List from './List';
import './styles.scss';

const Feedstocks = () => (
     
          <div className="d-flex">
            <Menu />
                <Switch>
                    <Route path="/admin/feedstocks" exact>
                        <List />
                    </Route>
                    <Route path="/admin/feedstocks/:feedstockId">
                        <Form />
                    </Route>
                </Switch>
        </div>
     
)

export default Feedstocks;
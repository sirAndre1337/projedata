import React from 'react';
import Routes from './Routes';
import 'bootstrap/dist/css/bootstrap.min.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const App = () => {
  return (
    <>
    <Routes />
    <ToastContainer />
    </>
  )
}

export default App;

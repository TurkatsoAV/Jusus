import React from "react";
import Login from "../login/Login";
import Dashboard from "../dashboard/Dashboard";
import {BrowserRouter, Route} from "react-router-dom";

const App: React.FC = () =>
    <BrowserRouter>
        <Route path="/login" component={Login}/>
        <Route path="/dashboard" component={Dashboard}/>
    </BrowserRouter>;
export default App;

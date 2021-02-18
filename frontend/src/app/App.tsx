import React from "react"
import {Dashboard, Login} from "../screen"
import {HashRouter, Route} from "react-router-dom"

export const App: React.FC = () => (
    <HashRouter>
        <Route path="/login" component={Login} />
        <Route path="/dashboard" component={Dashboard} />
    </HashRouter>
)

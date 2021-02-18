import React from "react"
import "./signin.css"
import Form from "react-bootstrap/Form"
import Button from "react-bootstrap/Button"

export const Login: React.FC = () => (
    <div className="container">
        <Form className="form-signin">
            <h2 className="form-signin-heading">Please sign in</h2>
            <p>
                <label htmlFor="username" className="sr-only">
                    Username
                </label>
                <Form.Control
                    className="form-control"
                    placeholder="Username"
                    required
                />
            </p>
            <p>
                <label htmlFor="password" className="sr-only">
                    Password
                </label>
                <Form.Control
                    type="password"
                    className="form-control"
                    placeholder="Password"
                />
            </p>
            <Button className="btn btn-lg btn-primary btn-block" type="submit">
                Sign In
            </Button>
        </Form>
    </div>
)

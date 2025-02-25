import { Button, TextField } from "@mui/material";
import { ErrorMessage, Field, Formik, Form } from "formik";
import React from "react";
import * as Yup from "yup";
import { loginUserAction } from "../../Redux/Auth/auth.action";
import { useDispatch } from "react-redux";


const initialValues = { email: "", password: "" };

const validationSchema = Yup.object({
  email: Yup.string().email("Invalid email").required("Email is required"),
  password: Yup.string()
    .min(6, "Password must be at least 6 characters")
    .required("Password is required"),
});

const Login = () => {
  const dispatch=useDispatch();

  const handleSubmit = (values) => {
    console.log("Submitted values:", values);
    dispatch(loginUserAction(values))
  };

  return (
    <>
      <Formik
        onSubmit={handleSubmit}
        validationSchema={validationSchema}
        initialValues={initialValues}
      >
        {({ handleSubmit }) => (
          <Form onSubmit={handleSubmit} className="space-y-5">
            <div className="space-y-5">
              <div>
                <Field
                  as={TextField}
                  name="email"
                  placeholder="Email"
                  type="email"
                  variant="outlined"
                  fullWidth
                />
                <ErrorMessage name="email" component="div" className="text-red-500" />
              </div>

              <div>
                <Field
                  as={TextField}
                  name="password"
                  placeholder="Password"
                  type="password"
                  variant="outlined"
                  fullWidth
                />
                <ErrorMessage name="password" component="div" className="text-red-500" />
              </div>
            </div>

            <Button
              sx={{ padding: "8px 0" }}
              fullWidth
              type="submit"
              variant="contained"
              color="primary"
            >
              Login
            </Button>
          </Form>
        )}
      </Formik>
    </>
  );
};

export default Login;






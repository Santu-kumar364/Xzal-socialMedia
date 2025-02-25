import React, { useState } from "react";
import { Button, TextField, FormControlLabel, Radio, RadioGroup } from "@mui/material";
import { ErrorMessage, Field, Formik, Form } from "formik";
import * as Yup from "yup";
import { useDispatch } from "react-redux";
import { registerUserAction } from "../../Redux/Auth/auth.action";


const initialValues = {
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  gender: "",
};

const validationSchema = Yup.object({
  firstName: Yup.string().required("First Name is required"),
  lastName: Yup.string().required("Last Name is required"),
  email: Yup.string().email("Invalid email").required("Email is required"),
  password: Yup.string()
    .min(6, "Password must be at least 6 characters")
    .required("Password is required"),
  gender: Yup.string().required("Gender is required"),
});

const Register = () => {
  const [formValues] = useState(initialValues);
  const dispatch=useDispatch();

  const handleSubmit = (values) => {
    console.log("Submitted values:", values);

    dispatch(registerUserAction({ data:values }))
  };

  return (
    <>
      <Formik
        initialValues={formValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ handleSubmit }) => (
          <Form onSubmit={handleSubmit} className="space-y-5">
            <div className="space-y-5">
              <div>
                <Field
                  as={TextField}
                  name="firstName"
                  placeholder="First Name"
                  type="text"
                  variant="outlined"
                  fullWidth
                />
                <ErrorMessage name="firstName" component="div" className="text-red-500" />
              </div>

              <div>
                <Field
                  as={TextField}
                  name="lastName"
                  placeholder="Last Name"
                  type="text"
                  variant="outlined"
                  fullWidth
                />
                <ErrorMessage name="lastName" component="div" className="text-red-500" />
              </div>

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

              <div>
                <Field as={RadioGroup} row name="gender">
                  <FormControlLabel value="female" control={<Radio />} label="Female" />
                  <FormControlLabel value="male" control={<Radio />} label="Male" />
                </Field>
                <ErrorMessage name="gender" component="div" className="text-red-500" />
              </div>
            </div>

            <Button
              sx={{ padding: "8px 0" }}
              fullWidth
              type="submit"
              variant="contained"
              color="primary"
            >
              Register
            </Button>
          </Form>
        )}
      </Formik>
    </>
  );
};

export default Register;

import {
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAILURE,
} from "./auth.action.Type";
import axios from "axios";
import { API_BASE_URL } from "../../config/Api";


export const loginUserAction = (loginData) => async (dispatch) => {
    try {
      dispatch({ type: LOGIN_REQUEST });
  
      const { data } = await axios.post(`${API_BASE_URL}auth/signin`, loginData);
  
      if (data.token || data.jwt) {
        localStorage.setItem("jwt", data.token || data.jwt);
      }
  
      console.log("Login success:", data);
      dispatch({ type: LOGIN_SUCCESS, payload: data.token || data.jwt });
    } catch (error) {
      console.error(
        "Login error:",
        error.response ? error.response.data : error.message
      );
      dispatch({
        type: LOGIN_FAILURE,
        payload: error.response ? error.response.data.message : error.message,
      });
    }
  };
  


export const registerUserAction = (registerData) => async (dispatch) => {
  try {
    dispatch({ type: REGISTER_REQUEST });
    const { data } = await axios.post(
      `${API_BASE_URL}auth/signup`,
      registerData.data
    );

    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    console.log("Register success:", data);
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
  } catch (error) {
    console.error("Register error:", error.response?.data || error.message);
    dispatch({
      type: REGISTER_FAILURE,
      payload: error.response?.data || error.message,
    });
  }
};

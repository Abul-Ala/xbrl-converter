import React, { useReducer } from 'react';
import {
  TextField,
  Button,
  Typography,
  Box,
  Paper,
} from '@mui/material';
import { useLoginMutation } from '../../api/login';
import { get } from "@/utils/lodash";
import { useNavigate } from "react-router-dom";
import { handleError } from "@/utils/error";

const Login = () => {

  const navigate = useNavigate();

const [localState, setLocalState] = useReducer((prevState, newState) => ({ ...prevState, ...newState }), {
  username: "",
  password: "",
  showPassword: false,
});

const { username, password, showPassword} = localState;

const [login, { isFetching }] = useLoginMutation();

const handleClickShowPassword = () =>
  setLocalState({
    showPassword: !showPassword,
  });

const handleMouseDownPassword = (event) => {
  event.preventDefault();
};

const onHandleChange = (event) => {
  const { name, value } = event.target;
  setLocalState({ [name]: value });
};
const handleKeyPress = (e) => {
  const { key } = e;
  if (username && password && key === "Enter") {
    handleLogin();
  }
};

const handleLogin = () => {
  const payload = {
    username,
    password,
  };
  login(payload)
  .unwrap()
  .then((res) => {
    const token = get(res, "results.token", "");
    sessionStorage.setItem("token", token);
    navigate("/app/form");
  })
  .catch((error) => handleError(error)); // Ensure the error is passed here

};


  return (
    <Paper
          elevation={3}
          sx={{
            padding: 3,
            borderRadius: 2,
            backgroundColor: 'rgba(255, 255, 255, 0.8)', 
          }}
        >
          <Typography component="h1" variant="h5" align="center">
            Login
          </Typography>
          <Box
            component="form"
            noValidate
            sx={{ mt: 2 }}
            onSubmit={(e) => {
              e.preventDefault();
              // Handle login logic here
            }}
          >
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email Address"
              value={username}
              name="username"
              autoComplete="email"
              onKeyDown={handleKeyPress}
              onChange={onHandleChange}
              autoFocus
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
              onKeyDown={handleKeyPress}
              onChange={onHandleChange}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              sx={{ mt: 3, mb: 2 }}
              onClick={handleLogin} 
            >
              Login
            </Button>
            <Typography variant="body2" color="text.secondary" align="center">
              Forget Password? <a href="/forget">Forget</a>
            </Typography>
          </Box>
        </Paper>
  )
}

export default Login
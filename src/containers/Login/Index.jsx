import React from 'react';
import LoginForm from "@/components/LoginForm";
import { Container, Box } from '@mui/material';
import background from "@/assets/background.jpg"; 

const Login = () => {
  return (
    <Box
      sx={{
        backgroundImage: `url(${background})`, 
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
      }}
    >
      <Container component="main" maxWidth="xs">
        <LoginForm />
      </Container>
    </Box>
  );
};

export default Login;

import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import PropertyDetails from './pages/PropertyDetails';
import SignUp from './pages/SignUp';
import LogIn from './pages/Login';
import SignUpSuccess from './pages/SignUpSuccess';
import SignUpFailure from './pages/SignUpFailure';
import PostPropety from './pages/PostProperty';
import ForgotPassword from './pages/ForgotPassword';
import ChangePassword from './pages/ChangePassword';
import ChangePassWordFailure from './pages/ChangePassWordFailure';
import ChangePasswordSuccess from './pages/ChangePasswordSuccess';

const App = () => {
  return (
    <div className='max-w-[1440px] mx-auto bg-white'>
      
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/property/:id" element={<PropertyDetails />} />
        <Route path="/signup" element={<SignUp/>} />
        <Route path="/login" element={<LogIn/>} />
        <Route path="/signup/success" element={<SignUpSuccess/>} />
        <Route path="/signup/failure" element={<SignUpFailure/>} />
        <Route path="/property/add" element={<PostPropety/>} />
        <Route path="/forgot-password" element={<ForgotPassword/>} />
        <Route path="/change-password" element={<ChangePassword/>} />
        <Route path="/change-password/success" element={<ChangePasswordSuccess/>} />
        <Route path="/change-password/failure" element={<ChangePassWordFailure/>} />
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
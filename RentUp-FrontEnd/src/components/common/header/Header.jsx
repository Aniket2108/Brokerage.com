import React, { useState } from "react";
import "./header.css";
import { nav } from "../../data/Data";
import { Link } from "react-router-dom";

const Header = () => {
  const [navList, setNavList] = useState(false);
  const [loggedIn, setLoggedIn] = useState(false); // Add state for tracking login status

  const handleLogin = () => {
    // Logic for handling login
    setLoggedIn(true);
  };

  const handleLogout = () => {
    // Logic for handling logout
    setLoggedIn(false);
  };

  return (
    <>
      <header>
        <div className="container flex">
          <div className="logo">
            <img src="./images/logo.png" alt="" />
          </div>
          <div className="nav">
            <ul className={navList ? "small" : "flex"}>
              {nav.map((list, index) => (
                <li key={index}>
                  <Link to={list.path}>{list.text}</Link>
                </li>
              ))}
            </ul>
          </div>
          <div className="button flex">
            {loggedIn ? (
              // If logged in, show profile and logout buttons
              <>
                <button className="btn1">
                  <Link to="/profile">Profile</Link>
                </button>
                <button className="btn1" onClick={handleLogout}>
                  Logout
                </button>
              </>
            ) : (
              // If not logged in, show login and signup links
              <>
                <button className="btn1">
                  <Link to="/login" onClick={handleLogin}>
                    Login
                  </Link>
                </button>
                <button className="btn1">
                  <Link to="/signup">Signup</Link>
                </button>
              </>
            )}
          </div>

          <div className="toggle">
            <button onClick={() => setNavList(!navList)}>
              {navList ? (
                <i className="fa fa-times"></i>
              ) : (
                <i className="fa fa-bars"></i>
              )}
            </button>
          </div>
        </div>
      </header>
    </>
  );
};

export default Header;

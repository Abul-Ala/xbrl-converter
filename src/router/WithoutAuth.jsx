import { Navigate } from "react-router-dom";
// import { MISCurrentUser } from "utils/validations";
import PropTypes from "prop-types";

export const WithoutAuth = ({ children }) => {
  const { sessionToken } = {};

  if (sessionToken) {
    return <Navigate to="/app/login" />;
  }
  return children;
};

WithoutAuth.propTypes = {
  children: PropTypes.node.isRequired,
};

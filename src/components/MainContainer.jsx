import PropTypes from "prop-types";
import { ToastContainer, Zoom } from "react-toastify";
import { TOAST_DISMISS_TIMEOUT } from "@/settings/constants/toast";
import "react-toastify/dist/ReactToastify.css";

const MainContainer = ({ children }) => {
  return (
    <>
      {children}

      <ToastContainer
        position="top-center"
        autoClose={TOAST_DISMISS_TIMEOUT}
        hideProgressBar
        newestOnTop
        closeOnClick={false}
        rtl={false}
        pauseOnFocusLoss
        draggable={false}
        pauseOnHover={false}
        transition={Zoom}
        theme="colored"
      />
  
    </>
  );
};

MainContainer.propTypes = {
  children: PropTypes.node.isRequired,
};

export default MainContainer;

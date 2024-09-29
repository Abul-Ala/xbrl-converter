import { toast } from "react-toastify";
import { handleLogout } from "./logout";
import { get } from "./lodash";

export const handleError = (error) => {
  console.log("Error received:", error);
  
  // Attempt to access error message in different places
  const errorMsg =  get(error, "data.message") || 
                   get(error, "data.results") || 
                   get(error, "data.error") || 
                   error.message || 
                   "An unknown error occurred";

  if (errorMsg) {
    toast.error(errorMsg);
  }

  if (get(error, "status") === 417) {
    handleLogout(errorMsg);
  }
};

import T from "@/T";
import { toast } from "react-toastify";
import { loginStore } from "@/slice/loginSlice";
import { store } from "@/providers/store";

import { loadingStore } from "@/slice/loadingSlice";

export const handleLogout = async (msg = T.LOGOUT_SUCCESS) => {
  store.dispatch(loadingStore({ storedLoading: true }));
  await new Promise((resolve) => {
    setTimeout(() => {
      store.dispatch(loginStore({ token: "", user: {} }));
      resolve();
    }, 0);
  });
  localStorage.clear();
  sessionStorage.clear();
  window.location.href = "/app/login";
  toast.success(msg);

};

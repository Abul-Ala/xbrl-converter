import { combineReducers } from "redux";

import { api } from "@/api";
import LoginSlice from "@/slice/loginSlice";
const rootReducer = combineReducers({
  LoginSlice,
  [api.reducerPath]: api.reducer,
});

export default rootReducer;

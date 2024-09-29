import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import Constants from "../Constants";
import { get } from "../utils/lodash"
// //import { CACHE_TAG_TYPES } from "./cacheTagTypes";

export const api = createApi({
  reducerPath: "apiReducer",
  baseQuery: fetchBaseQuery({
    baseUrl: "http://localhost:8181/api/v1",
    credentials: 'include', // Include credentials for CORS
    prepareHeaders: (headers, { getState }) => {
      const state = getState();
      const token = get(sessionStorage, "token") || get(state, "LoginSlice.loginToken");
      headers.set("X-Content-Type-Options", "nosniff");
      if (token) {
        headers.set("Authorization", `Bearer ${token}`); 
      }
      return headers;
    },
  }),
  endpoints: (builder) => ({
  }),
});

import { createSlice } from "@reduxjs/toolkit";

export const loadingSlice = createSlice({
  name: "LoadingSlice",
  initialState: { storedLoading: false },
  reducers: {
    loadingStore: (state, action) => {
      state.storedLoading = action.payload.storedLoading;
    },
  },
});

export const { loadingStore } = loadingSlice.actions;

export default loadingSlice.reducer;

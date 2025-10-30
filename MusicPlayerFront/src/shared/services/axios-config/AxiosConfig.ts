import Axios, { type AxiosInstance } from "axios";
import { Environment } from "../../env";
import { errorInterceptor, responseInterceptor } from "../interceptors";

export const Api = (): AxiosInstance => {
  const instance: AxiosInstance = Axios.create({
    baseURL: Environment.API_BASE_URL,
  });

  instance.interceptors.response.use(
    (response) => responseInterceptor(response),
    (error) => errorInterceptor(error)
  );

  return instance;
};

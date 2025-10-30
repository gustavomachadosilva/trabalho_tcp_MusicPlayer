import type { AxiosResponse } from "axios";

export const responseInterceptor = (
  response: AxiosResponse<unknown>
): AxiosResponse<unknown> => {
  return response;
};

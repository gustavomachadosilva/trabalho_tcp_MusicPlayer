import type { AxiosError } from "axios";

export interface IResultOfAction<T = unknown> {
  data: T;
  message: string;
  success: boolean;
}

export const errorInterceptor = <T = unknown>(
  error: AxiosError<IResultOfAction<T>>
): Promise<IResultOfAction<T>> => {
  const data = error.response?.data;

  const buildError = (message: string, data?: T): IResultOfAction<T> => ({
    data: data ?? ("" as unknown as T),
    message: message,
    success: false,
  });

  switch (error.response?.status) {
    case 404:
      return Promise.reject(
        buildError("Recurso não encontrado [404]", data?.data)
      );

    case 401:
      return Promise.reject(
        buildError("Não autorizado ou sessão expirada [401]")
      );

    case 403:
      return Promise.reject(buildError("Acesso negado [403]"));

    default:
      if (error.message === "Network Error") {
        return Promise.reject(buildError("Erro de conexão com o servidor"));
      }
      return Promise.reject(buildError("Erro inesperado", data?.data));
  }
};

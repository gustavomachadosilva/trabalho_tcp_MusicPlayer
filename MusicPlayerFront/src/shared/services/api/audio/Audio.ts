import { Api } from "../../axios-config";
import { type IResultOfAction } from "../../interceptors";

const getAudio = async (): Promise<IResultOfAction<string>> => {
  try {
    const request = await Api().get("audio/file", {
      responseType: "blob",
    });

    const response: IResultOfAction<string> = {
      Success: true,
      Message: "Audio convertido com sucesso!",
      Data: URL.createObjectURL(request.data),
    };

    return response;
  } catch (error) {
    return error as IResultOfAction<string>;
  }
};

export const AudioService = {
  getAudio,
};

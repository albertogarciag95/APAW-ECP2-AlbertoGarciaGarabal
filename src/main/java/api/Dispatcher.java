package api;

import api.dto.InstrumentoDTO;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import api.restControllers.InstrumentoRestController;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private InstrumentoRestController instrumentoRestController = new InstrumentoRestController();

    public void submit(HttpRequest request, HttpResponse response) {
        try {
            switch (request.getMethod()) {
                case POST:
                    this.postAction(request, response);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("Unexpected method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(exception.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(exception.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(exception);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void postAction(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(InstrumentoRestController.INSTRUMENTOS)) {
            response.setBody(this.instrumentoRestController.create((InstrumentoDTO) request.getBody()));
        }
        else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

}
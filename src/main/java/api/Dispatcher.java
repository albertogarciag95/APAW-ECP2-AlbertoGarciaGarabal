package api;

import api.dto.InstrumentoDTO;
import api.dto.MusicoDTO;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import api.restControllers.InstrumentoRestController;
import api.restControllers.MusicoRestController;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private InstrumentoRestController instrumentoRestController = new InstrumentoRestController();

    private MusicoRestController musicoRestController = new MusicoRestController();

    public void submit(HttpRequest request, HttpResponse response) {
        try {
            switch (request.getMethod()) {
                case POST:
                    this.postAction(request, response);
                    break;
                case GET:
                    this.getAction(request, response);
                    break;
                case PUT:
                    this.putAction(request, response);
                    break;
                default:
                    throw new RequestInvalidException("Unexpected method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(exception.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(exception.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            exception.printStackTrace();
            response.setBody(exception);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void putAction(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(InstrumentoRestController.INSTRUMENTOS + InstrumentoRestController.INSTRUMENTO_ID)) {
            response.setBody(this.instrumentoRestController.update(request.getPath(1), (InstrumentoDTO) request.getBody()));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    public void postAction(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(InstrumentoRestController.INSTRUMENTOS)) {
            response.setBody(this.instrumentoRestController.create((InstrumentoDTO) request.getBody()));
        } else if(request.isEqualsPath(MusicoRestController.MUSICOS)) {
            response.setBody(this.musicoRestController.create((MusicoDTO) request.getBody()));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    public void getAction(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(InstrumentoRestController.INSTRUMENTOS + InstrumentoRestController.INSTRUMENTO_ID)) {
            response.setBody(this.instrumentoRestController.findById(request.getParams().get("id")));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

}
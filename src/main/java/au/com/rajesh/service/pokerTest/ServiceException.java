package au.com.rajesh.service.pokerTest;

public class ServiceException extends RuntimeException {
	private String errorCode;
	private String errorMessage;
	
    public ServiceException(String code) {
        this.errorCode =code;
    }

    public ServiceException(String code, String message) {
    	this.errorCode =code;
    	this.errorMessage =message;
    }
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}






	
}

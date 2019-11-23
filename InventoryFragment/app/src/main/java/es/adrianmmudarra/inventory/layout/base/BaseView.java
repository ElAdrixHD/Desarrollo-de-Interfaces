package es.adrianmmudarra.inventory.layout.base;

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showError(String error);
    void onSuccess(String message);
}

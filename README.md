# Tienda Virtual con Patrones de Diseño

## Descripción del problema
Desarrollo de una tienda virtual funcional desde consola donde el cliente puede agregar productos al carrito, seleccionar forma de pago, aplicar descuentos y recibir notificaciones automáticas al confirmar la compra. Se aplican los patrones Strategy, Adapter y Observer.

## Explicación de cada patrón dentro del contexto de la tienda

### Strategy (Descuentos)
- Interfaz `DiscountStrategy` con método `applyDiscount`.
- Estrategias concretas: `NoDiscount` (sin descuento), `PercentageDiscount` (descuento porcentual, ej. 10%), `FixedAmountDiscount` (descuento de monto fijo, ej. S/ 20).
- El carrito (`ShoppingCart`) puede cambiar de estrategia en tiempo de ejecución por composición.

### Adapter (Método de pago)
- La tienda define `PaymentProcessor` con `pay(double amount)`.
- Servicio externo `ExternalPayPalService` con `makePayment(String currency, double amount)`.
- `PayPalAdapter` implementa `PaymentProcessor` y traduce `pay` a `makePayment` con moneda "PEN".

### Observer (Notificaciones)
- Interfaz `OrderObserver` con método `update(String message)`.
- Observadores concretos: `EmailNotificationObserver` (envío de correo al cliente), `InventoryObserver` (actualización de inventario), `AdminNotificationObserver` (notificación al administrador).
- Cuando se confirma la orden (`Order.confirm()`), se notifica automáticamente a todos los observadores registrados.

## Ejemplo de salida en consola
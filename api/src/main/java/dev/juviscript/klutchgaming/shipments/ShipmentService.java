package dev.juviscript.klutchgaming.shipments;

import dev.juviscript.klutchgaming.shipments.model.Shipment;
import dev.juviscript.klutchgaming.shipments.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Optional<Shipment> getShipmentByOrderId(Long orderId) {
        return shipmentRepository.findByOrderId(orderId);
    }

    public Optional<Shipment> getShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public void markAsDelivered(Long id) {
        shipmentRepository.findById(id).ifPresent(shipment -> {
            shipment.setDeliveredAt(LocalDateTime.now());
            shipmentRepository.save(shipment);
        });
    }

    public void deleteShipment(Long id) {
        shipmentRepository.findById(id).ifPresent(shipment -> {
            shipment.setDeletedAt(LocalDateTime.now());
            shipmentRepository.save(shipment);
        });
    }
}

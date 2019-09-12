package com.ritualsoftheold.terra.core;

import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.materials.Registry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a single Terra world.
 *
 */
public interface TerraWorld {
    /**
     * Adds a load marker. User should make sure that
     * {@link #()} is not in progress.
     *
     * @param marker Load marker.
     */
    void addMarker(Marker marker);

    /**
     * Removes a load marker. User should make sure that
     * {@link #()} is not in progress.
     *
     * @param marker Load marker.
     */
    void removeMarker(Marker marker);

    /**
     * Requests load markers to be updated.
     *
     * @return List of completable futures which need to be completed
     * before everything is loaded.
     */
    void updateMarker(Marker marker);

    boolean checkMarker(Marker marker);

    Registry getRegistry();

    void initialWorldGeneration(Marker marker);
}

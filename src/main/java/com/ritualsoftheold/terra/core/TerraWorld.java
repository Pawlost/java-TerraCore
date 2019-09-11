package com.ritualsoftheold.terra.core;

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
     * {@link #updateLoadMarkers()} is not in progress.
     *
     * @param marker Load marker.
     */
    void addLoadMarker(Marker marker);

    /**
     * Removes a load marker. User should make sure that
     * {@link #updateLoadMarkers()} is not in progress.
     *
     * @param marker Load marker.
     */
    void removeLoadMarker(Marker marker);

    /**
     * Requests load markers to be updated.
     *
     * @return List of completable futures which need to be completed
     * before everything is loaded.
     */
    List<CompletableFuture<Void>> updateLoadMarkers();

    Registry getRegistry();

    void initialWorldGeneration(Marker player);
}

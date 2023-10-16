// Generated by Dagger (https://dagger.dev).
package com.example.kelineyt.fragments.categories;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NutritionFragment_MembersInjector implements MembersInjector<NutritionFragment> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public NutritionFragment_MembersInjector(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  public static MembersInjector<NutritionFragment> create(
      Provider<FirebaseFirestore> firestoreProvider) {
    return new NutritionFragment_MembersInjector(firestoreProvider);
  }

  @Override
  public void injectMembers(NutritionFragment instance) {
    injectFirestore(instance, firestoreProvider.get());
  }

  @InjectedFieldSignature("com.example.kelineyt.fragments.categories.NutritionFragment.firestore")
  public static void injectFirestore(NutritionFragment instance, FirebaseFirestore firestore) {
    instance.firestore = firestore;
  }
}

# spy-network
Assignment for 2ME3 at McMaster, that involved creating a network of spies, fieldbases, and a homebase that could communicate through encrypted messages.  
  
Requirements for this assignment were as follows:
- There are three entities within the network: a home base, field bases, and spies. There may
be multiple field bases and spies, but there is only one home base.  
- Field bases are associated/registered with the home base, and spies are associated/registered
with a single field base.  
- To perform shady activities and protect the home base from liability/culpability, field bases
are allowed to “go dark”, in which case they can unregister from the home base. They can
choose to re-register with the home-base at any point in the future.  
- Spies do not have the ability to unregistered from the field base. However, they wear a device
at all times such that if they die, a signal is sent to the field base to unregister them – it’s like
they never existed. If a “dead” spy tries to re-register with a field base the field base does not
allow it.  
- All entities share an encryption scheme and a key. The scheme and key are both determined by
the home base. When the home base changes the scheme or the key, it sends the new scheme
and/or key to all field bases currently in the network. In turn, the field base will send the
updated information to all spies registered with it.  
- Spies, field bases, and the home base all have the ability to send messages and receive messages
from each other. For example, a spy can send a message to a spy, a field base can send a message
to the home base, the home base can send a message to a spy, a spy can send a message to
the home base, etc. When an entity sends a message they do not send it in plain text, they
send an encrypted messaged using their most up-to-date scheme info. When an entity receives
a message, they decrypt it using their most up-to-date scheme info and store it in some way.  

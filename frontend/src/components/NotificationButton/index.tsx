import axios from 'axios';
import { toast } from 'react-toastify';
import notification from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
  saleId: number;
}
function NotificationButton({ saleId }: Props) {

  function handleClick(id: number) {
    axios.get(`${BASE_URL}/sales/${id}/notification`)
      .then(response => toast.info("SMS Enviado com Sucesso!!!"))
  }

  return (
    <div
      className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
      <img
        src={notification}
        alt="Notificar" />
    </div>
  )
}

export default NotificationButton;
